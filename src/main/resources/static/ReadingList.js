const ADDR = "http://localhost:3306"

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

const printResult = (result) => {

    const RESULTS_DIV = document.createElement("div");
    RESULTS_DIV.setAttribute("class", "results-div");

    const RESULTS = document.createElement("p");
    RESULTS.setAttribute("class", "results");
    RESULTS.textContent = `${result.bookName}  |  ${result.author}  |  ${result.genre}  |  ${result.readingStatus}  |  ${result.isbn}`

    const BUTTONS_DIV = document.createElement("div");
    BUTTONS_DIV.setAttribute("class", "buttonsdiv-el");

    BUTTONS_DIV.appendChild(RESULTS);
    RESULTS.appendChild(RESULTS_DIV);
    RESULTS-DIV.appendChild(RESULTS);

}