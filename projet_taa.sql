-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 04 Janvier 2019 à 14:09
-- Version du serveur :  5.7.24-0ubuntu0.18.04.1
-- Version de PHP :  5.6.37-1+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_taa`
--

-- --------------------------------------------------------

--
-- Structure de la table `choice`
--

CREATE TABLE `choice` (
  `id` bigint(20) NOT NULL,
  `choice_date` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `sport_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `choice`
--

INSERT INTO `choice` (`id`, `choice_date`, `last_update`, `level_id`, `person_id`, `sport_id`) VALUES
(1, '2019-01-03 17:49:15', '2019-01-03 17:49:15', 2, 1, 2),
(6, '2019-01-03 20:25:35', '2019-01-03 20:25:35', 1, 5, 1),
(7, '2019-01-04 13:00:50', '2019-01-04 13:00:50', 2, 1, 6),
(9, '2019-01-04 13:05:40', '2019-01-04 13:05:40', 1, 8, 4);

-- --------------------------------------------------------

--
-- Structure de la table `choice_places`
--

CREATE TABLE `choice_places` (
  `choice_id` bigint(20) NOT NULL,
  `places_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `choice_places`
--

INSERT INTO `choice_places` (`choice_id`, `places_id`) VALUES
(1, 1),
(1, 3),
(6, 3),
(7, 3),
(9, 4);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10),
(10),
(10),
(10),
(10),
(10);

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

CREATE TABLE `level` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `level`
--

INSERT INTO `level` (`id`, `name`) VALUES
(1, 'débutant'),
(2, 'intermédiaire'),
(3, 'confirmé');

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `person`
--

INSERT INTO `person` (`id`, `email`, `firstname`, `lastname`, `password`, `username`) VALUES
(1, 'a@gmail.com', 'ines', 'BIS', '$2a$10$L4/POH1z0PGDcQ6ZNd5ntuisDr9REQI/6GGv/nY94zy.s6/a7f/Um', 'ane'),
(2, 'vivi@gmail.com', 'ines', 'BIS', '$2a$10$FV9mUpq3BdpNiBXDq39f.ObcxundYtin4gF4ApKX9Pbo1oE6LBc76', 'ane'),
(3, 'mama@gmail.com', 'mama', 'mama', '$2a$10$DWedBT4Io6mRhiCYGpV9se3nc5MDPN7caiXl5TmtYfXZgs9M4DSWm', 'ma'),
(4, 'n@gmail.com', 'Hounkanrin', 'Viviane', '$2a$10$BtCrHFUbdOGpxe5mXgRWMOKLLPR9q5lQzYtBVbRPY5cQCcLxuqA9S', NULL),
(5, 'r@gmail.com', 'reine', 'reine', '$2a$10$/3qdMrSVJMcGkHc/XaPKxu7sz5Mn4k6DKODglfAI1399yMzg6MTly', NULL),
(8, 'v@gmail.com', 'Hounkanrin', 'Viviane', '$2a$10$lmgsCZgV.4Mn0BPn3Xf4PuKxBZps40mQ626e3r00wFhgVqdxcBMry', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `person_roles`
--

CREATE TABLE `person_roles` (
  `person_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `person_roles`
--

INSERT INTO `person_roles` (`person_id`, `roles_id`) VALUES
(1, 2),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(8, 1);

-- --------------------------------------------------------

--
-- Structure de la table `place`
--

CREATE TABLE `place` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `place`
--

INSERT INTO `place` (`id`, `name`) VALUES
(1, 'Saint-Etienne'),
(2, 'Angers'),
(3, 'Orléans'),
(4, 'Lyon'),
(5, 'Rennes');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, NULL, 'user'),
(2, NULL, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE `sport` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sport`
--

INSERT INTO `sport` (`id`, `name`) VALUES
(1, 'handball'),
(2, 'football'),
(3, 'Ruby'),
(4, 'Natation'),
(5, 'Tennis'),
(6, 'Volley-ball');

-- --------------------------------------------------------

--
-- Structure de la table `sport_places`
--

CREATE TABLE `sport_places` (
  `sport_id` bigint(20) NOT NULL,
  `places_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sport_places`
--

INSERT INTO `sport_places` (`sport_id`, `places_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 3),
(2, 1),
(3, 4),
(1, 4),
(2, 3),
(3, 5),
(1, 2),
(2, 4),
(3, 1),
(4, 2),
(5, 1),
(4, 4),
(5, 5),
(6, 3),
(6, 4);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `choice`
--
ALTER TABLE `choice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKaecdcqrt82a3a13ae734w6bnm` (`level_id`),
  ADD KEY `FKjspq4k5pf01b711pw2ulkocs0` (`person_id`),
  ADD KEY `FK1wv2tq2koytcbb010kkkf744e` (`sport_id`);

--
-- Index pour la table `choice_places`
--
ALTER TABLE `choice_places`
  ADD KEY `FKqdcxrraayx12njk70cbeasdkm` (`places_id`),
  ADD KEY `FK61t0079eiou0n3gdhe3is4mji` (`choice_id`);

--
-- Index pour la table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `person_roles`
--
ALTER TABLE `person_roles`
  ADD PRIMARY KEY (`person_id`,`roles_id`),
  ADD KEY `FK7s0o6k42r2stk8tc0qk2r5t4i` (`roles_id`);

--
-- Index pour la table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sport_places`
--
ALTER TABLE `sport_places`
  ADD KEY `FKdx3lms8yku85h0w7oyi16jamy` (`places_id`),
  ADD KEY `FK3gfvvlteqt0i3i1ump3kc6p2w` (`sport_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
