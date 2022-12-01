//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.util.ArrayList;

public class ResearchMagazine extends Research{
    //Constructor ths ResearchStudyMagazine pou arxikopoiei ths metavlhtes ths
    public ResearchMagazine(ArrayList <String> Authors,String TitlePeriodiko,int NumberSelides,int Etos,int MagazineVolume,String SelidaDhmosieushs){
        
        this.type=true;
        
        this.Authors=Authors;
        this.TitlePeriodiko = TitlePeriodiko;
        this.NumberSelides = NumberSelides;
        this.Etos = Etos;
        this.MagazineVolume = MagazineVolume;
        this.SelidaDhmosieushs = SelidaDhmosieushs;      
    }
    
}
