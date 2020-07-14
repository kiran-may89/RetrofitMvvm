package com.methods.retrofitmvvm.dto

data class ContentListPage(
	val page: Page? = null
)

data class ContentItems(
	val content: List<ContentItem?>? = null
)

data class Page(
	val pageNum: String? = null,
	val pageSize: String? = null,
	val contentItems: ContentItems? = null,
	val totalContentItems: String? = null,
	val title: String? = null
)

data class ContentItem(
	val name: String? = null,
	val posterImage: String? = null
)

