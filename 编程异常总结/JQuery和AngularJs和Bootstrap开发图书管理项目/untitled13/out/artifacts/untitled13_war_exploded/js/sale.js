app.controller("ListSalesController", ['$scope', function ($scope){
		$.get("getAllSales", null , function(data, statusText)
			{
				if (data.exception)
				{
					alert("与服务器交互出现异常：" + data.exception);
				}
				else
				{
					$scope.$apply(function () {
						$scope.sales = data;
					});
				}
			});
	}])
	.controller("SaleBookController", ['$scope', function ($scope){
		$.get("getAllBooks", null , function(data, statusText)
			{
				if (data.exception)
				{
					alert("与服务器交互出现异常：" + data.exception);
				}
				else
				{
					$scope.$apply(function () {
						$scope.books = data;
						$scope.bookId = data[0].id;
					});
				}
			});
		// 设置默认的折扣
		$scope.discount = 0.7;
		// 设置默认的销售数量
		$scope.amount = 1;
		// 当用户改变下拉列表框时激发该函数
		$scope.cal = function(myevent)
		{
			$scope.selected = $('select#bookId').prop('selectedIndex');
		};
		$scope.add = function(){
			$.post("saleBook" , $(".form-horizontal").serializeArray() , 
				// 指定回调函数
				function(data , statusText)
				{
					if(data.exception)
					{
						alert("与服务器交互出现异常：" + data.exception);
					}
					else if(data.status > 0)
					{
						alert("图书销售成功!");
						// 清空表单的内容
						$(".form-horizontal").get(0).reset();
					}
					else
					{
						alert("图书销售失败！");
					}
				},
				// 指定服务器响应为json
				"json");
			return false;
		}	
	}])