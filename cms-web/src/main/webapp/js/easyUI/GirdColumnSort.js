/*
 数字类型排序
 */  
function numberSort(a,b){  
    	 var number1 = parseFloat(a);  
    	 var number2 = parseFloat(b);  
    	   
    	 return (number1 > number2 ? 1 : -1);    
    }  
/*
日期类型排序
*/  
function dataSorter(a,b){  
			a = a.split('/');  
			b = b.split('/');  
			if (a[2] == b[2]){  
				if (a[0] == b[0]){  
					return (a[1]>b[1]?1:-1);  
				} else {  
					return (a[0]>b[0]?1:-1);  
				}  
			} else {  
				return (a[2]>b[2]?1:-1);  
			}  
	}  