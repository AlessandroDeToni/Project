# Project

### Esempi di Test

###### GET:

- **Restituzione dell'intera lista in formato JSON:**
	
		path: "/Data"
	
	*http://localhost:8080/Data*
- **Restituzione della lista di metadati in formato JSON:**
	
		path: "/MetaData"
	
	*http://localhost:8080/MetaData*
- **Restituzione degli elementi unici presenti nel dataset:**
	
		path: "/ElementiUnici"
		params: key = "fieldname"
			value = uno tra: "freq", "geo", "unit", "instrtimeperiod"
	
	*per es. :http://localhost:8080/ElementiUnici?fieldname="geo"*
- **Restituzione delle statistiche in formato JSON:**
		
		path: "/Stats"
		params: key = "fieldname"
			value = uno degli anni compresi tra 2000 e 2017
		
	*per es. :http://localhost:8080/Stats?fieldname=2016*


###### POST: 
	
	path: "/Filter"
	
*http://localhost:8080/Filter*

 Di seguito elenco alcuni esempi di body per effettuare la request.
 Tenere conto conto che:
 	
 - "fieldname1" e "fieldname2" possono essere un qualunque campo della classe Record ("freq", "geo", "unit", "instrtimeperiod", 2000, 2001 ecc.) ma gli anni sono scritti per esteso (2000, 2001 ecc.)
 - "operator" può essere uno tra i seguenti operatori: "<",">","==","and","or". 
 	
 	- **"==", "<", ">";** 
	
		> body:
		 {
			"fieldname1": 2017,
			"operator":"==",
			"value1": 7.5
		 } 
	 
	 *(per gli anni "==" può essere sostituito da "<",">")*
 	 
 	- **"==" campi tipo Stringa;** 
	
		> body:
		{
			"fieldname1": "geo",
			"operator":"==",
			"value1": "IT"
		}
	
	- **"or", "and" (su un campo unico)** 

		> body:
		{
			"fieldname1": "geo",
			"operator":"or",
			"value1": "IT",
			"value2": "DE"
		} 

	*("or" può essere sostituito con "and")*
	
	- **"or", "and" (2 campi diversi);**
	
		> body:
		{
			"fieldname1": "geo",
			"fieldname2": 2014,
			"operator":"or",
			"value1": "IT",
			"value2": 0
		} 
	
	*("or" può essere sostituito con "and")*
	
### Pagina di Errore
La pagina di errore di default è stata personalizzata, se si utilizza postman utilizzare per una visione corretta del risultato "Preview" e non "Pretty".

### JavaDoc
![alt text] doc/allpackages-index.html
