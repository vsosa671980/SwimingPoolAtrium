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

const buttonModal = document.querySelector(".modal")

if (buttonModal) {
	buttonModal.addEventListener("click", event => modalform(event.target.value))
}
function modalform(url){
	
	fetch(url)
	.then(response => response.text())
	.then(data=> divdialog.innerHTML = data)
	.then(()=>createModal())
	
}
const button = document.querySelector(".modal")
console.log(button)
//Capture the button 
const modalSubscriptionInsert = document.getElementById("insertSubscription")

//Capture the dialog from HMTL
const modal = document.getElementById("modalinsert");
//Capture the Div where Modal is inserted
const divdialog = document.getElementById("modalformdialog");


function createModal(){
	const modal = document.getElementById("modalinsert");
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










 