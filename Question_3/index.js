const fetch = require('node-fetch');
const fs = require('fs');
const path = require('path')
console.log("here!");

let lang = process.argv[3]; 
let filename = process.argv[2];

fs.readFile(path.resolve(__dirname,filename), 'utf-8', (err, data) => {
    if(err){
        return console.log(err);
    }

    let sourceText = JSON.stringify(JSON.parse(data));
    var sourceLang = 'auto';
    var targetLang = lang;
  
    var url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl="
              + sourceLang + "&tl=" + targetLang + "&dt=t&q=" + encodeURI(sourceText);
    fetch(url).then((r) => r.json()).then((data)=> {
      console.log(data[0][0][0]);
    })
    
})