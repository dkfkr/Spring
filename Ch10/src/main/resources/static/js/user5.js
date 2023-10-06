$(function(){
				
	//User5
	$('#btnUser5s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user5',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser5').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user5/fg0120',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser5Register').click(function(){
		
		const jsonData = {
			id:'a101',
			name: '홍길동',
			gender: 'F',
			age: 23,
			addr: '경주시'
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user5',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser5Modify').click(function(){
		
		const jsonData = {
			name: '고길동',
			gender: 'F',
			age: 45,
			addr: '경주시'
		};
		
		$.ajax({
			url: '/Ch10/user5',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser5Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user5/김춘추',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
