<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class UserApp extends Model
{
    protected $table = 'user_apps';

    protected $fillable = ['email', 'password'];

    use HasFactory;
}
