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
        $review->email = $request->email;
        $review->password = $request->password;
        $review->save();

        return response()->json([
            "message" => "user record created"
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
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        if (UserApp::where('id', $id)->exists()) {
            $user = UserApp::where('id', $id)->get()->toJson(JSON_PRETTY_PRINT);
            return response($user, 200);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }    
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function edit(UserApp $user)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        if (UserApp::where('id', $id)->exists()) {
            $user = UserApp::find($id);
    
            $user->email = is_null($request->email) ? $user->email : $request->email;
            $user->password = is_null($request->password) ? $user->password : $request->password;
            $game->save();
    
            return response()->json([
              "message" => "records updated successfully"
            ], 200);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        if(UserApp::where('id', $id)->exists()) {
            $user = UserApp::find($id);
            $user->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
    }
}