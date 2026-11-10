import express from "express";

const app = express();

app.use(express.json())

app.post("/API/soma", (req, res) => {
    const num1 = req.body.numero1;
    const num2 = req.body.numero2;

    res.send({ soma: num1 + num2});
    console.log("post");
});
// app.post("/API", (req, res) => {

//     console.log("post");
// });

app.get("/API/soma", (req, res) => {
    // res.send("API funcando");
    // res.send("vai se fuder!  :)");

    // postman
    //http://localhost:3000/API/soma?produtoNome=banana&preco=10
   
    const produtoNome = req.query.produtoNome;
    const preco = Number(req.query.preco);

    if(preco > 0 && produtoNome){
        res.send({message : `o preco do produto ${produtoNome} eh ${preco}`});
    }else{
        res.send({message : "coloca o bagulho certo"});
    }
    
});

app.listen(3000, () => {
    console.log("servidor porra.")
});

console.log("hello world!");