import express from "express";

const app = express();

app.get("/", (req, res) => {
    res.send("API funcando")
});

app.listen(3000, () => {
    console.log("servidor porra.")
});

console.log("hello world!");