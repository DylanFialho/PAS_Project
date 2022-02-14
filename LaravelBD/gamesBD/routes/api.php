<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ApiController;
use App\Http\Controllers\UserApiController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('games', [ApiController::class, 'index']);
Route::get('games/{id}', [ApiController::class, 'show']);
Route::post('games', [ApiController::class, 'create']);
Route::put('games/{id}', [ApiController::class, 'update']);
Route::delete('games/{id}', [ApiController::class, 'destroy']);

Route::get('user', [UserApiController::class, 'index']);
Route::get('user/{id}', [UserApiController::class, 'show']);
Route::post('user', [UserApiController::class, 'create']);
Route::put('user/{id}', [UserApiController::class, 'update']);
Route::delete('user/{id}', [UserApiController::class, 'destroy']);
