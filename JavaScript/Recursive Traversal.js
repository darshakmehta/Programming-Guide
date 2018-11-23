var obj = [
    { name: 'Darshak', id: 1},
    [
      { name: 'Mehta', id: 1},
      [
        { name: 'Mehta', id: 1},
        { name: 'Love', id: 1},
        [
          { name: 'Mehta', id: 1},
          { name: 'Love', id: 1},
          [
          [
          [
            { name: 'one', id: 1},
            { name: 'Two', id: 1},
          ]
          ]
          ]
        ]
      ]
    ]
  ];

var printArr = (arr) => {
  for(let i = 0; i < arr.length; i++) {
    if(arr[i].length === undefined) {
      console.log(arr[i].name + " " + arr[i].id);
    } else {
      printArr(arr[i]);
    }
  }
}

printArr(obj);