
use pocketmine\item\Item;

class Gravel extends Fallable{
	public function __construct(){
		parent::__construct(self::GRAVEL, 0, "Gravel");
		$this->hardness = 3;
	}

	public function getDrops(Item $item){
		if(mt_rand(1, 10) === 1){
			return [
				[Item::FLINT, 0, 1],
			];
		}

		return [
			[Item::GRAVEL, 0, 1],
		];
	}

}