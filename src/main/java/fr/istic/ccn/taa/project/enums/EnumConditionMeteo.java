package fr.istic.ccn.taa.project.enums;

public enum EnumConditionMeteo {
    SKI(1L, -10, true, false),
    FOOT(2L, -10, true, false),
    HANDBALL(3L, -10, true, false),
    VOLEYBOL(4L, -10, true, false);



    private Long idMeteo;
    private double temperature;
    private boolean neige;
    private boolean soleil;

    public Long getIdMeteo() {
        return idMeteo;
    }

    public void setIdMeteo(Long idMeteo) {
        this.idMeteo = idMeteo;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isNeige() {
        return neige;
    }

    public void setNeige(boolean neige) {
        this.neige = neige;
    }

    public boolean isSoleil() {
        return soleil;
    }

    public void setSoleil(boolean soleil) {
        this.soleil = soleil;
    }

    EnumConditionMeteo(Long idMeteo, double temperature, boolean neige, boolean soleil){
        this.idMeteo = idMeteo;
        this.temperature = temperature;
        this.neige = neige;
        this.soleil= soleil;
    }


    public static EnumConditionMeteo getEnumBySport(Long idMeteo) {
        for (EnumConditionMeteo v : values()) {
            if (v.idMeteo.equals(idMeteo)) {
                return v;
            }
        }
        return null;
    }

}
