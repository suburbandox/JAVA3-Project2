$(".btn-open").on("click", function() {
    let title = $(this).attr("data-title");
    let population = $(this).attr("data-population");
    let region = $(this).attr("data-region");
    let lat = $(this).attr("data-lat");
    let lon = $(this).attr("data-lon");
    let cap = $(this).attr("data-cap");
    let sub = $(this).attr("data-sub");
    let text = "https://maps.google.com/maps?q=-15.79,-47.88&amp;z=4&amp;output=embed"
    console.log(`${cap} ${sub} ${lat} ${lon}`);
    //console.log(`${title} ${population} ${region}`);
    $(".modal-title").html(title);
    $(".modal-population").html(population);
    $(".modal-region").html(region);
    $(".modal-cap").html(cap);
    $(".modal-sub").html(sub);
    $(".modal-lat").html(lat);


});
