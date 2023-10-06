$(function(){
				
	//User6
	$('#btnUser6s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user6',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser6').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user6/32',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser6Register').click(function(){
		
		const jsonData = {
			name: '이순신',
			gender: 'M',
			age: 12,
			addr: '경주시'
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user6',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser6Modify').click(function(){
		
		const jsonData = {
			seq: 39,
			name: '홍길동',
			gender: 'F',
			age: 24,
			addr: '경주시'
		};
		
		$.ajax({
			url: '/Ch10/user6',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser6Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user6/41',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
