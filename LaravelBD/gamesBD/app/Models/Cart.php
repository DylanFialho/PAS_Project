<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Cart extends Model
{
    protected $table = 'user_cart';
    protected $fillable = ['id_game', 'id_user'];

    use HasFactory;
}
