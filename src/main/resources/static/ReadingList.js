const ADDR = "http://localhost:8080"

// Divs
const RESULTS_DIV = document.querySelector(".results-div");

// Buttons
const CREATE_BUTTON = document.querySelector(".createbutton-el")

// Inputs

// Get Request
const getAll = () => {
    axios.get(`${ADDR}/book/getAll`)
    .then((response) => {
        RESULTS_DIV.innerHTML = "";
        const RESULTS = response.data;
        for (let result of RESULTS) {
            printResult(result);
        }
    }).catch((error) => console.error(error))
}