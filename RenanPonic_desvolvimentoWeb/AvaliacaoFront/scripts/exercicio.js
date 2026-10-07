

function fazerContas(){
    
    const adicao = document.getElementById('adicao');
    const subtracao = document.getElementById('subtracao');
    const multiplicacao = document.getElementById('multiplicacao');
    const divisao = document.getElementById('divisao');
    
    const num1 = Number(document.getElementById('num1').value);
    const num2 = Number(document.getElementById('num2').value);
    
    console.log("num1:", num1);
    console.log("num2:",num2);
    adicao.textContent = num1 + num2;
    subtracao.textContent = num1 - num2;
    multiplicacao.textContent = num1 * num2;
    divisao.textContent = num1 / num2;
}

document.getElementById('resultados').addEventListener('click', fazerContas);


