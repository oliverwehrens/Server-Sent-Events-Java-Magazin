<html>
<head>

  <script type='text/javascript'>

    if (window.EventSource) {

      var source = new EventSource('http://localhost:8080/update.html');

      source.onmessage = function (event) {
        ev = document.getElementById('events');
        ev.innerHTML += "<br>[sse!] " + event.data;
      };

      source.addEventListener("server-time", function (e) {
        console.log("Event!");
        ev = document.getElementById('events');
        ev.innerHTML += "<br>[in] " + e.data;
      }, false);

      var eventSource = new EventSource('http://localhost:8080/events.html');

      eventSource.addEventListener('create', function (e) {
        ev = document.getElementById('events');
        ev.innerHTML += "<br>[CREATE] " + event.data;
      }, false);

      eventSource.addEventListener('update', function (e) {
        ev = document.getElementById('events');
        ev.innerHTML += "<br>[UPDATE] " + event.data;
      }, false);
    }
    else {
      alert("No Event source support.")
    }

  </script>
</head>
<body>


Events!

<div id="events"></div>

</body>
</html>