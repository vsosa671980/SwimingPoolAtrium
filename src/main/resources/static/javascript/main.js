//const boton = document.querySelectorAll("button");

//console.log(boton)


//boton.forEach(elemento=> elemento.addEventListener("click",mostrar))


//const insertBookings = document.getElementById("insertBookings")


//Function for call Fragments of 

//function mostrar(){
	
//	const id = event.target.value
	
//	fetch(`/booking/user/${id} `)
//	.then(response => response.text())
//	.then(data=> insertBookings.innerHTML = data)

	
//}

//----Process for Create the modals Forms in the app------///

const buttonModal = document.querySelectorAll(".modal")
console.log(buttonModal)

//Capture the Div where Modal is inserted
const divdialog = document.getElementById("modalformdialog");
console.log(divdialog)

//if node exist
if (buttonModal) {
	buttonModal.forEach(button =>{
		button.addEventListener("click", event => modalform(event.target.value))
	})

}

//Do a request to server for import modal form
function modalform(url){
	
	 fetch(url)
	.then(response => response.text())
	.then(data=> divdialog.innerHTML = data)
	.then(()=>createModal())
	
}
//const button = document.querySelector(".modal")
//console.log(button)
//Capture the button 
const modalSubscriptionInsert = document.getElementById("insertSubscription")
console.log(modalSubscriptionInsert )

//Capture the dialog from HMTL
const modal = document.getElementById("modalinsert");



function createModal(){
	const modal = document.getElementById("modalinsert");
	console.log(modal)
	const closeModal = document.getElementById("btnCerrar");
	closeModal.addEventListener("click",()=> modal.close())
	modal.showModal();
	
}
if (modalSubscriptionInsert) {
	modalSubscriptionInsert.addEventListener("click", event => modalform(event.target.value))
}

function createButton(){
	
	
modal.addEventListener("click",()=> modal.close())

}

const updateButton = document.querySelectorAll(".updateButton")

console.log(updateButton)

updateButton.forEach(button => button.addEventListener("click",event => updateForm(event.target.value)))

console.log(updateButton.value)


function updateForm ( url){

	fetch(url)
 .then(response => response.text())
. then(data=> divdialog.innerHTML = data)
 .then(()=>createModal())

}


const ocupacion = document.querySelectorAll(".ocupation");

console.log(ocupacion);

ocupacion.forEach( value => {

	console.log(value.value)
	console.log(value.textContent)
	if (value.textContent == 0){
		value.classList.add("alertOcupation");
		value.parentNode.firstElementChild.firstChild.remove();
	}
})

//Procces for create Tables of UserFile

const buttonRequest = document.querySelectorAll(".buttonRequest");
console.log((buttonRequest));

const insertUserForm = document.querySelector(".insertUserForm");
console.log(insertUserForm );
if (buttonRequest ){

	buttonRequest.forEach(button => button.addEventListener("click", event => insertTable(event.target.value)));

}

function insertTable(url){

	fetch(url)
		.then(response => response.text())
		.then(data=> insertUserForm.innerHTML = data)

}









 