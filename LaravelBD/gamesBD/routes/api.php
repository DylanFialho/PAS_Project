<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ApiController;
use App\Http\Controllers\UserApiController;
use App\Http\Controllers\GameReviewApiController;
use App\Http\Controllers\CartController;

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

Route::get('gameReview', [GameReviewApiController::class, 'index']);
Route::get('gameReview/{id}', [GameReviewApiController::class, 'show']);
Route::post('gameReview', [GameReviewApiController::class, 'create']);
Route::put('gameReview/{id}', [GameReviewApiController::class, 'update']);
Route::delete('gameReview/{id}', [GameReviewApiController::class, 'destroy']);

Route::get('userCart', [CartController::class, 'index']);
Route::get('userCart/{id}', [CartController::class, 'show']);
Route::post('userCart', [CartController::class, 'create']);
Route::put('userCart/{id}', [CartController::class, 'update']);
Route::delete('userCart/{id}', [CartController::class, 'destroy']);
