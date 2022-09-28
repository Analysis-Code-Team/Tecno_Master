addEventListener('DOMContentLoaded', () => {
    const btnmenu = document.querySelector('.btnmenu');

    btnmenu.addEventListener('click', () => {


        const menuLateral = document.querySelector('.menuLateral');
        if (menuLateral.style.display == "none") {
            menuLateral.style.display = "flex";


        } else {
            menuLateral.style.display = "none";

        }



    });

});