<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\GameWithReview;

class GameReviewApiControllerextends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $review = GameWithReview::get()->toJson(JSON_PRETTY_PRINT);
        return response($user, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $review = new GameWithReview;
        $review->ip_game = $request->ip_game;
        $review->id_user = $request->id_user;
        $review->post = $request->post;
        $review->save();

        return response()->json([
            "message" => "Review record created"
        ], 201);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\GameWithReview  $review
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        if (GameWithReview::where('id', $id)->exists()) {
            $review = GameWithReview::where('id', $id)->get()->toJson(JSON_PRETTY_PRINT);
            return response($user, 200);
          } else {
            return response()->json([
              "message" => "Review not found"
            ], 404);
          }    
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\GameWithReview  $review
     * @return \Illuminate\Http\Response
     */
    public function edit(GameWithReview $review)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\GameWithReview  $review
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        if (GameWithReview::where('id', $id)->exists()) {
            $review = GameWithReview::find($id);
    
            $review->id_game = is_null($request->id_game) ? $review->id_game : $request->id_game;
            $review->id_user = is_null($request->id_user) ? $review->id_user : $request->id_user;
            $review->post = is_null($request->post) ? $review->post : $request->post;
            $game->save();
    
            return response()->json([
              "message" => "records updated successfully"
            ], 200);
          } else {
            return response()->json([
              "message" => "Review not found"
            ], 404);
          }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\GameWithReview  $review
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        if(GameWithReview::where('id', $id)->exists()) {
            $review = GameWithReview::find($id);
            $review->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Review not found"
            ], 404);
          }
    }
}