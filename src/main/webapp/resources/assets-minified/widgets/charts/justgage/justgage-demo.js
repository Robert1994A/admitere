$(function(){window.onload=function(){var a=new JustGage({id:"g1",value:getRandomInt(0,100),min:0,max:100,title:"Big Fella",label:"pounds"}),b=new JustGage({id:"g2",value:getRandomInt(0,100),min:0,max:100,title:"Small Buddy",label:"oz"}),c=new JustGage({id:"g3",value:getRandomInt(0,100),min:0,max:100,title:"Tiny Lad",label:"oz"}),d=new JustGage({id:"g4",value:getRandomInt(0,100),min:0,max:100,title:"Little Pal",label:"oz"}),e=new JustGage({id:"g5",value:getRandomInt(0,100),min:0,max:100,title:"Little Pal",label:"oz"});setInterval(function(){a.refresh(getRandomInt(50,100)),b.refresh(getRandomInt(50,100)),c.refresh(getRandomInt(0,50)),d.refresh(getRandomInt(0,50)),e.refresh(getRandomInt(0,50))},2500)}});