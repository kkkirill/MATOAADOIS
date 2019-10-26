var source;
var style;

function init() {
    source = new ActiveXObject("Microsoft.XMLDOM");
    source.async = false;
    style = new ActiveXObject("Microsoft.XMLDOM");
    style.async = false;
    source.load("countries.xml");
    style.load("countries.xsl");
    document.all.item("xslresult").innerHTML = source.transformNode(style);
    return true;
}

function orderByName() {
    style.load("countries1.xsl");
    document.all.item("xslresult").innerHTML = source.transformNode(style);
    return true;
}

function orderByPopulation() {
    style.load("countries2.xsl");
    document.all.item("xslresult").innerHTML = source.transformNode(style);
    return true;
}

function orderByFoundingDate() {
    style.load("countries3.xsl");
    document.all.item("xslresult").innerHTML = source.transformNode(style);
    return true;
}