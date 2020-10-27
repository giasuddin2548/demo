package com.genxmultiplexer.retrofitusingmvvm.network

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    //https://jsonplaceholder.typicode.com/albums
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>


    //Query parameter
    //https://jsonplaceholder.typicode.com/albums?userId=3
    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId:Int): Response<Albums>

    //Path parameter
    //https://jsonplaceholder.typicode.com/albums/3          here 3 is album id

    @GET("/albums/{id}")
    suspend fun getAlbumsByPath(@Path(value = "id") albumId:Int): Response<AlbumsItem>


    @POST("/albums")
    suspend fun postAlbums(@Body albumsItem: AlbumsItem):Response<AlbumsItem>





}