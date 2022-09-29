angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }


    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }



    $scope.addProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
                $scope.newProduct = null;
            });
    }


    $scope.filter = function () {
        console.log($scope.calcAdd);
        $http({
            url: contextPath + '/products/price_between',
            method: 'get',
            params: {
                min: $scope.min,
                max: $scope.max
            }
        }).then(function (response) {
            $scope.ProductList = response.data;
            $scope.min = 0;
            $scope.max = 100;
        });
    }


    $scope.loadProducts();
});