let diff = (arr1, arr2) => {

    let newArray = arr2.concat(arr1);  //first joininng both arrays in one and storing it in newArray 
  
    console.log(newArray)

    let newestArray = [];

    for (let i=0 ; i<newArray.length ; i++) {  //NOW COMPARING EACH ELEMENT OF  newArray  WITH ARR1 AD ARR2 AND PUSHING NOT SAME VALUES TO newestArray
        if (arr1.indexOf(newArray[i])===-1) {
            newestArray.push(newArray[i]);
            console.log(newestArray + ' first array values')
        }  //Solution to my problem,I put this braces after the next if, because of that next if was not running. 

        if (arr2.indexOf(newArray[i])===-1) {
            newestArray.push(newArray[i]);
            console.log(newestArray + ' second array values')
        }
    }

    return newestArray;   //It is returning an empty arrray but it should return "pink wool"
}

// let farray = ["Alex", "Leslie", "Chioma", "Desi", "Jena", "Miracle"];
// let sarray = ["James", "Chioma", "Miracle", "Ambruce", "Sonia", "Nneka"]

// console.log(diff(farray, sarray))

let fNumArray = [1,2,3,5,7,8]
let sNumArray = [1,2,3,4,5,6,3]

console.log(diff(fNumArray, sNumArray))