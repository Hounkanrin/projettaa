#Application Week end 

L'application permet de la planification des activités du week sport d'un utlisateur.
Elle avertie les utilisateurs, enregistrés, des meilleurs endroits, en fonction de la meteo  
où ils peuvent pratiquer leurs sports favoris.

1 Lancement de l'application

1.1 Créer la base de données        
   -Créer une base de données de type mysql. 
    Ce <a href="https://itx-technologies.com/fr/blog/2108-installer-et-acceder-a-phpmyadmin-sous-ubuntu">lien</a> pourra vous aider.    
    
   -Après la création de la base de données, dans un terminal,      
         entrez les commandes suivantes:    
         <i>sudo su</i> (mettre votre mot de passe administrateur)  
         <i>/opt/lammp/lammp start</i>          
         
         <i>Ce aperçu vous indique que votre base de données à bien démarré</i>
         root@beugre-HP-EliteBook-840-G3:/home/beugre# /opt/lampp/lampp start
         Starting XAMPP for Linux 7.2.9-0...
         XAMPP: Starting Apache...already running.
         XAMPP: Starting MySQL...already running.
         XAMPP: Starting ProFTPD...already running.
                
   -Dans le navigateur, taper le lien http://localhost/phpmyadmin/ pour acceder à phpmyadmin.   
   
   -Une fois sur phpmyadmin, crée une base de données nommée "projet_taa", puis importer le fichier  projet_taa.sql     
   (présent à la racine du projet) qui permet de peupler la base de données
   
NB: Pour les informations sur la base de données, vous pouvez consulter le fichier application.properties.

1.2 Exécution du projet côté back end      
    L'exécution du back end permet de mettre en marche le serveur de l'application  
    
1.3 Exécution du projet côté front end  
Le front de l'application se trouve sur ce <a href="https://github.com/Hounkanrin/weekendtaa">lien</a>.     

    