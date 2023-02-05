var members = ['sangyong', 'egoing', 'mihua' ];
console.log(members[1]);
for(var i=0; i<members.length; i++){
  console.log('array loop', members[i]);
}

var roles = {
  'programmer':'sangyong',
  'teacher':'egoing'
};
console.log(roles.teacher);

for(var j in roles){
  console.log('key => ', j, 'value => ', roles[j]);
};