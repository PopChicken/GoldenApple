

class Bookshelf extends Solid{
	public function __construct(){
		parent::__construct(self::BOOKSHELF, 0, "Bookshelf");
		$this->hardness = 7.5;
	}

}