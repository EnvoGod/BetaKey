
    $(window).ready(function () {
    <!-- Insert here your absolute path without domain name  -->
    history.pushState({}, '/betakey', window.location.pathname);
});


        document.getElementById('closebutton').onclick = function () {
        disappear()
    }

        function disappear() {
        document.getElementById('closebutton').parentElement.style.opacity = "0";
        setTimeout(function () {
        document.getElementById('closebutton').parentElement.style.display = "none";
    }, 600);
    }
