<?php

namespace App\Http\Controllers;

use App\Models\Game;
use Illuminate\Http\Request;

class ApiController extends Controller
{

  public function index()
    {
        //
        $game = Game::all();
        return view('game.list', compact('game','games'));
    }

    public function create()
    {
        //
        return view('game.create');
    }

    public function store(Request $request)
    {
        //
        $request->validate([
            'txtTitle'=>'required',
            'txtDescription'=> 'required',
            'txtCategory' => 'required',
            'txtConsole' => 'required',
            'txtPrice' => 'required',
            'txtImage' => 'required'
        ]);

        $game = new Game([
            'name' => $request->get('txtTitle'),
            'description'=> $request->get('txtDescription'),
            'category'=> $request->get('txtCategory'),
            'console'=> $request->get('txtConsole'),
            'price'=> $request->get('txtPrice'),
            'imurlage'=> $request->get('txtImage')
        ]);

        $game->save();
        return redirect('/game')->with('success', 'Game has been added');
    }

    public function show(Game $game)
    {
        return view('game.view',compact('game'));
    }

    public function edit(Game $game)
    {
        return view('game.edit',compact('game'));
    }

    public function update(Request $request,$id)
    {

        $request->validate([
            'txtTitle'=>'required',
            'txtDescription'=> 'required',
            'txtCategory' => 'required',
            'txtConsole' => 'required',
            'txtPrice' => 'required',
            'txtImage' => 'required',
        ]);


        $game = Game::find($id);
        $game->name = $request->get('txtTitle');
        $game->description = $request->get('txtDescription');
        $game->category = $request->get('txtCategory');
        $game->console = $request->get('txtConsole');
        $game->price = $request->get('txtPrice');
        $game->url = $request->get('txtImage');

        $game->update();

        return redirect('/game')->with('success', 'Game updated successfully');
    }

    public function destroy(Game $game)
    {
        //
        $game->delete();
        return redirect('/game')->with('success', 'Game deleted successfully');
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function indexApi()
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
    public function createApi(Request $request)
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
    public function storeApi(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Game  $game
     * @return \Illuminate\Http\Response
     */
    public function showApi($id)
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
    public function editApi(Game $game)
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
    public function updateApi(Request $request, $id)
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
    public function destroyApi($id)
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
