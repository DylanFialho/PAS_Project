<?php

namespace App\Http\Controllers;

use App\Models\Game;
use Illuminate\Http\Request;

class ApiController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $games = Game::get()->toJson(JSON_PRETTY_PRINT);
        return response($games, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $game = new Game;
        $game->url = $request->url;
        $game->name = $request->name;
        $game->description = $request->description;
        $game->category = $request->category;
        $game->console = $request->console;
        $game->price = $request->price;
        $game->save();

        return response()->json([
            "message" => "game record created"
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
     * @param  \App\Models\Game  $game
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        if (Game::where('id', $id)->exists()) {
            $game = Game::where('id', $id)->get()->toJson(JSON_PRETTY_PRINT);
            return response($game, 200);
          } else {
            return response()->json([
              "message" => "Game not found"
            ], 404);
          }    
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Game  $game
     * @return \Illuminate\Http\Response
     */
    public function edit(Game $game)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Game  $game
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        if (Game::where('id', $id)->exists()) {
            $game = Game::find($id);
    
            $game->url = is_null($request->url) ? $game->url : $request->url;
            $game->name = is_null($request->name) ? $game->name : $request->name;
            $game->description = is_null($request->description) ? $game->description : $request->description;
            $game->category = is_null($request->category) ? $game->category : $request->category;
            $game->console = is_null($request->console) ? $game->console : $request->console;
            $game->price = is_null($request->price) ? $game->price : $request->price;
            $game->save();
    
            return response()->json([
              "message" => "records updated successfully"
            ], 200);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Game  $game
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        if(Game::where('id', $id)->exists()) {
            $game = Game::find($id);
            $game->delete();
    
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
