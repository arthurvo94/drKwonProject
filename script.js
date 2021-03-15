const fusList = ["22532","22533","22534","22610","22818","22819","22558","22585","22586NC","22612","22614","22632","22634","22800","22804","22812","22808","22810"];
const decList = ["63056","63057","63081","63082","63087","63088","63090","63091","63102","63103","63302","63303","63306","63307","63308","22100","22103",
"62287NC","62380","63001","63003","63012","63015","63016","63017","63047","630320","63030","63035","63042","63043","63044","63048","63170","63185","63190","63191","63200",
"63252","63267","63268","63272","63273","63277","63278","63282","63283","63287","63290","63302","63303","63306","63307","63308"];
const instList = ["22853","22854","22859","22840","22841","22842","22843","22844","22845","22846","22847","27280","22830","27279NC"];
const otherList = ["20930","20931","20936","20937","20938","22830"];

const text = document.getElementById("input");
const codePrint = document.getElementById("all");
var isEmpty = true;

fus = [];
dec = [];
inst = [];
other = [];
codeList = [];

text.addEventListener("keydown", function(e){
    if(e.keyCode === 13){
        add(document.querySelector("input").value.trim());
    }
})

function add(x){
    text.value = "";
    //returns if code has already been added
    if(codeList.indexOf(x) != -1){
        return false;
    }

    if(fusList.indexOf(x) != -1){
        fus.push(x);
    }
    else if(decList.indexOf(x) != -1){
        dec.push(x);
    }
    else if(instList.indexOf(x) != -1){
        inst.push(x);
    }
    else if(otherList.indexOf(x) != -1){
        other.push(x);
    }
    else{
        window.alert("CPT code not in scope");
        return false;
    }

    codeList.push(x);
    
    if(isEmpty){
        isEmpty = false;
        codePrint.innerHTML+= "Codes entered: [" + codeList.join(", ") + "]";
    }

    codeList.push(x);

    return true;  
}




