window.onSpotifyIframeApiReady = (IFrameAPI) => {

    let element = document.getElementById('embed-iframe');
    let u = document.getElementById("u").innerHTML
    let  l = u.toString()
    console.log(l)
    //console.log(u)
    //console.log(document.getElementById("u").innerHTML)
    let options = {
        uri: 'spotify:track:3D9TYPbNo1nnTwE4eLKxnJ'
    };
    let callback = (EmbedController) => {};
    IFrameAPI.createController(element, options, callback);
};
