
use pocketmine\item\Item;

class Melon extends Transparent{
	public function __construct(){
		parent::__construct(self::MELON_BLOCK, 0, "Melon Block");
		$this->hardness = 5;
	}

	public function getDrops(Item $item){
		return [
			[Item::MELON_SLICE, 0, mt_rand(3, 7)],
		];
	}
}