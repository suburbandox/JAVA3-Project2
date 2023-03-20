$(".btn-open").on("click", function() {
    let title = $(this).attr("data-title");
    let population = $(this).attr("data-population");
    let region = $(this).attr("data-region");
    let latitude  = $(this).attr("data-lat");
    let longitude  = $(this).attr("data-lon");
    let cap = $(this).attr("data-cap");
    let sub = $(this).attr("data-sub");
    let area = $(this).attr("data-area");
    let a = 1;

    if (area <= 70000){a = 6}
    if(area > 70000){a = 5}

    if (area > 5000000){a = 4}
console.log(`${a}`)
    //console.log(`${cap} ${sub} ${latitude} ${longitude}`);
    //console.log(`${title} ${population} ${region}`);
    $(".modal-title").html(title);
    $(".modal-population").html(population);
    $(".modal-region").html(region);
    $(".modal-cap").html(cap);
    $(".modal-sub").html(sub);
    $(".modal-map").html(`
            <iframe 
            width="100%" 
            height="480" 
            frameborder="0" 
            scrolling="no" 
            marginheight="0" 
            marginwidth="0"
            src="https://maps.google.com/maps?q=${latitude},${longitude}&amp;z=${a}&amp;output=embed">
            <br>
            <a href="https://www.google.com/maps/@${latitude},${longitude},${a}z" target="_blank">
            See full page map
            </a></iframe>
    `);


});
