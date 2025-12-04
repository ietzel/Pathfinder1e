public class Necromancy extends School {
    public boolean fatigue;
    public boolean shake;
    public boolean animatefourhdpercasterlevel;
    public boolean abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction;
    public boolean disease;
    public Necromancy(String name, boolean fatigue, boolean shake, boolean animatefourhdpercasterlevel, boolean abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction, boolean disease) {
        super(name);    
        this.fatigue = fatigue;
        this.shake = shake;
        this.animatefourhdpercasterlevel = animatefourhdpercasterlevel;
        this.abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction = abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction;
        this.disease = disease;
    }
}