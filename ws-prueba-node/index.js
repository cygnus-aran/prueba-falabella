import express from "express";
import bodyParser from "body-parser";

const app = express();
const PORT = 8080;
const digits = "0123456789";
const symbols = "!@#$%^&*()_+/-+.;'[]{}";
app.use(express.json());

app.post('/prueba/codificar', (req, res) => {
	var split = req.body.fuente.split("");
	var dig = digits.split("");
	var sym = symbols.split("");
	let r1 = Math.floor(Math.random() * sym.length);	
	let r2 = Math.floor(Math.random() * dig.length);

	var response = "";
	for (let i = 0; i < split.length; i++) {
		for (let i = 0; i < Math.floor(Math.random() * 4); i++) {

		  response = response + dig[Math.floor(Math.random() * dig.length)] + sym[Math.floor(Math.random() * sym.length)];
		}

		response = response + split[i];

		for (let i = 0; i < Math.floor(Math.random() * 4); i++) {
		  response = response + dig[Math.floor(Math.random() * dig.length)] + sym[Math.floor(Math.random() * sym.length)];
		} 
	}
	res.status(200).send({
		respuesta: response 
	})
});

app.post('/prueba/decodificar', (req, res) => {
	var response = req.body.fuente.replace(/[^a-zA-Z\s]/gi, '');
	res.status(200).send({
		respuesta: response
	})
});

app.listen(PORT, () => console.log('Server Running'));