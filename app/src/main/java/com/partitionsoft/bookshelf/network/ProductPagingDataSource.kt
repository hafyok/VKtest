package com.partitionsoft.bookshelf.network


import com.partitionsoft.bookshelf.network.model.newModels.VK

/*
class ProductPagingDataSource(private val productRetrofit: ProductRetrofit
): PagingSource<Int, VK>() {

    override fun getRefreshKey(state: PagingState<Int, VK>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VK> {
        return try {
            val page = params.key ?: 1
            val limit = 20
            val response = productRetrofit.vkProdSearch(limitResults = limit, maxResults = 20) ?: emptyList()
            val nextKey = if (response.isEmpty()) null else response.size.plus(page).plus(1)
            val prevKey = if (page == 1) null else response.size.minus(limit)

            Log.d("checkData", "page: $page, response.size: ${response.size}, nextKey: $nextKey, prevKey: $prevKey")

            LoadResult.Page(
                data = response,
                nextKey = nextKey,
                prevKey = prevKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}*/
