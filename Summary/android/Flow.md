# flow

## Fragment

```kotlin
viewLifecycleOwner.lifecycleScope.launch {
            productListViewModel.productListFlow.collectLatest { products ->
                Log.d("products", products.toString())
                listAdapter.submitList(products)
            }
        }
```

## ViewModel

```kotlin
val productListFlow: Flow<List<DutyFreeProductViewItem>> =
        combine(tabNameFlow, DutyFreeDataRepository.searchQuery) { category, searchQuery ->
            ProductListKeyword(category, searchQuery)
        }.flatMapLatest { keyword ->
            Log.d("keyword", "$keyword")
            if (keyword.category.isNotBlank()) {
                if (keyword.searchQuery.isNotBlank()) {
                    roomShopDao.getShopProductList(
                        ShopCategory.SHOP_DUTY_FREE.code,
                        keyword.category,
                        keyword.searchQuery
                    )
                        .distinctUntilChanged()
                        .map { list ->
                            list.map {
                                DutyFreeProductViewItem(it)
                            }
                        }
                } else {
                    roomShopDao.getShopProductList(
                        ShopCategory.SHOP_DUTY_FREE.code,
                        keyword.category
                    )
                        .distinctUntilChanged()
                        .map { list ->
                            list.map {
                                DutyFreeProductViewItem(it)
                            }
                        }
                }
            } else {
                roomShopDao.getShopProductList(ShopCategory.SHOP_DUTY_FREE.code)
                    .distinctUntilChanged()
                    .map { list ->
                        list.map {
                            DutyFreeProductViewItem(it)
                        }
                    }
            }

        }
```

## Repository

```kotlin
@Query("SELECT " +
       "P.PRODUCTNM AS PRODUCTNM, P.PRODUCTCD AS PRODUCTCD, PC.COST_USD AS COST_USD, " +
       "PC.COST_KRW AS COST_KRW, (L.loadingqty - ifnull(PS.prepqty,0)) AS PRODUCT_CNT, PC.DIS_RATE AS DIS_RATE " +
       "FROM tb_ts_product AS P, tb_ts_productcost AS PC, tb_ts_loading AS L LEFT JOIN tb_ts_prep_sale AS PS, app_local_category_name AS C " +
       "WHERE 1 = 1 " +
       "AND P.productcd = PC.productcd " +
       "AND PC.productcd = L.productcd " +
       "AND P.CATEGORY1 = :shopCode " +
       "AND P.category2 = C.category2 " +
       "AND (:tab IS NULL OR C.category_name LIKE :tab) " +
       "AND (:query is null OR P.PRODUCTNM LIKE '%'||:query||'%' OR P.PRODUCTCD LIKE '%'||:query||'%')"
    )
    fun getShopProductList(shopCode: String, tab: String? = null, query: String? = null): Flow<List<ShopStockDataObject>>

```

