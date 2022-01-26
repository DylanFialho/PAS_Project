<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class GameWithReview extends Model
{
    protected $table = 'game_with_review';

    protected $fillable = ['id_game', 'id_user', 'post'];

    use HasFactory;
}
