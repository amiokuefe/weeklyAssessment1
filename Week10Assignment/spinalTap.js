let spinalCase = (str) => {
  return str.replace(/([a-z])([A-Z])/g, '$1 $2')
    .replace(/\s+|_+/g, '-')
    .toLowerCase();
}

let testStr = "Hello Freaky Freaky?";

console.log(spinalCase(testStr))
