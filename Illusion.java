public class Illusion extends School {
    public boolean ghostsound;
    public boolean invisibility;
    public boolean mirrorimage;
    public Illusion(String name, boolean ghostsound, boolean invisibility, boolean mirrorimage) {
        super(name);    
        this.ghostsound = ghostsound; 
        this.invisibility = invisibility; 
        this.mirrorimage = mirrorimage;
    }
}