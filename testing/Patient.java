package testing;

import java.util.ArrayList;

public class Patient{
    private String id;
    private ArrayList<String> fus, dec, inst, other, codesList;
    private final String[] fusList = new String[] {"22532","22533","22534","22610","22818","22819","22558","22585","22586NC","22612","22614","22632","22634","22800","22804","22812","22808","22810"};
    private final String[] decList = new String[] {"63056","63057","63081","63082","63087","63088","63090","63091","63102","63103","63302","63303","63306","63307","63308","22100","22103",
            "62287NC","62380","63001","63003","63012","63015","63016","63017","63047","630320","63030","63035","63042","63043","63044","63048","63170","63185","63190","63191","63200",
            "63252","63267","63268","63272","63273","63277","63278","63282","63283","63287","63290","63302","63303","63306","63307","63308"};
    private final String[] instList = new String[] {"22853","22854","22859","22840","22841","22842","22843","22844","22845","22846","22847","27280","22830","27279NC"};
    private final String[] otherList = new String[] {"20930","20931","20936","20937","20938","22830"};

    //patient constructor
    public Patient(String id){
        this.id = id;
        fus = new ArrayList<>();
        dec = new ArrayList<>();
        inst = new ArrayList<>();
        other = new ArrayList<>();
        codesList = new ArrayList<>();
    }

    //add code to codesList and respective category list
    public boolean add(String code){
        if(search(code, fusList))
            fus.add(code);
        else if(search(code, decList))
            dec.add(code);
        else if(search(code, instList))
            inst.add(code);
        else if(search(code, otherList))
            other.add(code);
        else {
            if(!(code.equals("DONE") || code.equals("QUIT")))
                System.out.println("CPT code not in scope");
            return false;
        }
        codesList.add(code);
        return true;
    }

    //linear seach. return true if list contains code, false otherwise
    public boolean search(String code, String[] list){
        for(int i = 0; i < list.length; i++){
            if(code.equals(list[i]))
                return true;
        }
        return false;
    }

    public void print(){
        System.out.printf("%-16s", "PATIENT " + id );
        System.out.println(codesList.toString());
        System.out.println();

        if(!fus.isEmpty()){
            System.out.printf("%-16s", "FUSION");
            System.out.println(fus.toString());
        }
        if(!dec.isEmpty()){
            System.out.printf("%-16s", "DECOMPRESSION");
            System.out.println(dec.toString());
        }
        if(!inst.isEmpty()){
            System.out.printf("%-16s", "INSTRUMENTATION");
            System.out.println(inst.toString());
        }
        if(!other.isEmpty()){
            System.out.printf("%-16s", "OTHER");
            System.out.println(other.toString());
        }
        System.out.println();
    }

    //removes code from codesList and respective category list
    public boolean remove(String code){
        codesList.remove(code);

        if(fus.remove(code))
            return true;
        else if(dec.remove(code))
            return true;
        else if(inst.remove(code))
            return true;
        else if(other.remove(code))
            return true;
        else
            return false;
    }
}