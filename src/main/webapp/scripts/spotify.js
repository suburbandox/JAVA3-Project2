window.onSpotifyIframeApiReady = (IFrameAPI) => {

    let element = document.getElementById('embed-iframe');
    let u = document.getElementById("u").innerHTML
    let  l = u.toString()
    let test = 'spotify:track:3D9TYPbNo1nnTwE4eLKxnJ'
    console.log(l)
    //console.log(u)
    //console.log(document.getElementById("u").innerHTML)
    let options = {
        uri: u
    };
    let callback = (EmbedController) => {};
    IFrameAPI.createController(element, options, callback);
};
