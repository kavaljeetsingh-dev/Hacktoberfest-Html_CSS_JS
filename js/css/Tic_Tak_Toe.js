
let boxes = document.querySelectorAll(".box");
let reset = document.querySelector("#reset");
let newgame = document.querySelector("#newgame");
let win = document.querySelector(".win");
let msg = document.querySelector("#msg");
let turn0 = true;
let count = 0;
let draw=false;
const patterns = [

    [0, 1, 2],
    [0, 3, 6],
    [0, 4, 8],
    [1, 4, 7],
    [2, 5, 8],
    [2, 4, 6],
    [3, 4, 5],
    [6, 7, 8],
];

boxes.forEach((box) => {
    box.addEventListener("click", () => {
        if (turn0) {
            box.innerText = "O";
            turn0 = false;
        }
        else {
            box.innerText = "X";
            turn0 = true;
        }
        count++;
        console.log(count);
        box.disabled = true;
        checkwin();
    })
})

const resetbut = () => {
    turn0 = true;
    enablebox();
    win.classList.add("hide");
    count = 0;
    draw=false;


}
const disablebox = () => {
    for (box of boxes) {
        box.disabled = true;
    }
}

const enablebox = () => {
    for (box of boxes) {
        box.disabled = false;
        box.innerText = "";
    }
}
const show = (winner) => {
    msg.innerText = `winner is ${winner}`;
    win.classList.remove("hide");
    disablebox();
}


const checkwin = () => {
    for (pattern of patterns) {
        pos1 = boxes[pattern[0]].innerText;
        pos2 = boxes[pattern[1]].innerText;
        pos3 = boxes[pattern[2]].innerText;
        if (pos1 !== "" && pos2 !== "" && pos3 !== "") {
            if ((pos1 === pos2 && pos2 === pos3)) {
                console.log("winner", pos1);
                show(pos1);
                 draw=true;
                 break;

            }
        }

        }

        if (count === 9 && !draw) {
                msg.innerText = "match draw";
                win.classList.remove("hide");
                disablebox();
            }
            
    }





newgame.addEventListener("click", resetbut);
reset.addEventListener("click", resetbut);















