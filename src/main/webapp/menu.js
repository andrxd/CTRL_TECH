function limpar() {
document.getElementById('nome').value="";
document.getElementById('sobrenome').value="";
document.getElementById('rg').value="";
document.getElementById('dia').value="dd";
document.getElementById('mes').value="mm";
document.getElementById('ano').value="aaaa";
document.getElementById('filial').value="";
document.getElementById('cargo').value="";
document.getElementById('email').value="";
document.getElementById('pass').value="";
document.getElementById('passconfirm').value="";

}

var usuario = new Object();

var nome ;
var sobrenome;
var rg;
var dia;
var mes;
var ano;
var filial;
var cargo;
var email;
var pass;

function enviar(){
nome=document.getElementById('nome');
usuario.nome =nome;
usuario.sobrenome = document.getElementById('sobrenome');
rg=document.getElementById('rg');
dia=document.getElementById('dia');
mes=document.getElementById('mes');
ano=document.getElementById('ano');
filial=document.getElementById('filial');
cargo=document.getElementById('cargo');
email=document.getElementById('email');
pass=document.getElementById('pass');

usuario.nome= nome.value;
usuario.sobrenome=sobrenome.value;

}
