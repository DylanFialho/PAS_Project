<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class UserApp extends Model
{
    protected $table = 'userapp';

    protected $fillable = ['url', 'username', 'email', 'password'];

    use HasFactory;
}
